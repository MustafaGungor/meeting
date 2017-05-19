import React from "react";
import ModalDataForm from "robe-react-ui/lib/form/ModalDataForm";
import DataGrid from "robe-react-ui/lib/datagrid/DataGrid";
import Assertions from "robe-react-commons/lib/utils/Assertions";
import RemoteEndPoint from "robe-react-commons/lib/endpoint/RemoteEndPoint";
import ShallowComponent from "robe-react-commons/lib/components/ShallowComponent";
import Store from "robe-react-commons/lib/stores/Store";
import MeetingModel from "./model/MeetingModel.json";

export default class Meeting extends ShallowComponent {

    static idField = "id";

    constructor(props) {
        super(props);

        let store = new Store({
            endPoint: new RemoteEndPoint({
                url: "MEETİNG",
            }),
            idField: Meeting.idField,
            autoLoad: true
        });

        this.state = {
            fields: MeetingModel.fields,
            store: store,
            showModal: false,
            item: {},
            propsOfFields: {
                parentOid: {
                    items: []
                }
            }
        };
    }

    render() {
        return (
            <div header="Meetings">
                <DataGrid
                    fields={this.state.fields}
                    store={this.state.store}
                    propsOfFields={this.state.propsOfFields}
                    ref={"table"}
                    toolbar={[{name: "create", text: "Ekle"}, {name: "edit", text: "Düzenle"}, {
                        name: "delete",
                        text: "Sil"
                    }]}
                    onNewClick={this.__add}
                    onEditClick={this.__edit}
                    onDeleteClick={this.__remove}

                />
                <ModalDataForm
                    ref="meeting"
                    header="Meetings"
                    show={this.state.showModal}
                    propsOfFields={this.state.propsOfFields}
                    fields={this.state.fields}
                    onSubmit={this.__onSave}
                    onCancel={this.__onCancel}
                    defaultValues={this.state.item}
                />
            </div>
        );
    }

    __add() {
        let empty = {};
        this.__showModal(empty);
    }

    __edit() {
        let selectedRows = this.refs.table.getSelectedRows();
        if (!selectedRows || !selectedRows[0]) {
            return;
        }
        if(selectedRows[0].parent != null){
            selectedRows[0].parentOid=selectedRows[0].parent.oid;
        }
        this.__showModal(selectedRows[0]);
    }

    __onCancel() {
        this.setState({showModal: false});
    }

    __onSave(newData, callback) {
        let id = newData[Menu.idField];
        newData.parent = this.__findRoleObject(newData.parentOid);
        if (Assertions.isNotEmpty(id)) {
            this.state.store.update(newData);
        } else {
            this.state.store.create(newData);
        }
        if (newData) {
            callback(true);
            this.setState({
                showModal: true
            });
        }
        // this.refs[DataGridSample.tableRef].__readData();
    }

    __remove() {
        let selectedRows = this.refs.table.getSelectedRows();
        this.state.store.delete(selectedRows[0]);
    }

    __showModal(newItem) {
        this.setState({showModal: true, item: newItem});
    }


}
