import React from 'react';
import {Row,Col,Button} from 'react-bootstrap';
import {Link} from 'react-router';
class App extends React.Component {
   render() {
      return (
      <div>
      <Row>
         <Col md={3}>
         	<ul>
         		<Link to="/home">home</Link><br/>
         		<Link to="/employee">employee</Link><br/>
         		<Link to="/department">department</Link><br/>
         		<Link to="/meeting">meeting</Link><br/>
         	</ul>
         </Col>
         <Col md={9}>
         	{this.props.children}
         </Col>
         </Row>
         </div>
      );
   }
}

export default App;
