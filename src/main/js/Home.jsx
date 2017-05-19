import React from 'react';
import {Col,Button,ListGroup,ListGroupItem} from 'react-bootstrap';

class Home extends React.Component {
	render(){
		return(
		<Row>
			<Col md = {3}>
				<ListGroup>
					<ListGroupItem href="/home">Home</ListGroupItem>
					<ListGroupItem href="/employee">Employee</ListGroupItem>
					<ListGroupItem href="/department">Department</ListGroupItem>
					<ListGroupItem href="/meeting">Meeting</ListGroupItem>

				</ListGroup>
			</Col>
			<Col md={9}>
				<div>
				{this.props.children}
				</div>
			</Col>
		</Row>

			
		)
	}
}
export default Home;