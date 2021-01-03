import React, { useState, useEffect } from 'react';

import AppBar from './appBarForTableOrder/AppBar';
import { DataGrid } from '@material-ui/data-grid';




const orderTable = (props) => {

  const [pom, setPom] = useState([]);
  
  useEffect(() => {
    const rows = props.listOrders ? props.listOrders.map(ord => {
      return {id: ord.orderId, price: `${ord.totalPrice} Czk`, status: ord.orderstate}
    }) : [];
      setPom(rows)
  }, [props.listOrders])

  const columns = [
    { field: 'id', headerName: 'ID', width: 150 },
    { field: 'price', headerName: 'Cena', width: 150 },
    { field: 'status', headerName: 'Status', width: 150 }
  ];


    return (
        <React.Fragment>
            <AppBar />
            <div style={{  marginTop: '80px'}}>
            <DataGrid rows={pom} autoHeight autoWidth columns={columns} pageSize={8} onRowClick={(e) => props.orderClickCallback(e.row.id)}/>
            </div>
        </React.Fragment>
    )
}

export default orderTable;