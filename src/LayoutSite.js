import React from "react";
import { Layout, Menu, Breadcrumb } from "antd";
import { Link } from "react-router-dom";

function LayoutSite(props) {
  const { Header, Content, Footer } = Layout;
  return (
    <Layout className="layout">
      <Header>
        <div className="logo" />
        <Menu theme="dark" mode="horizontal">
          <Link to={{pathname: "/"}}>
            <Menu.Item key="1">Home</Menu.Item>
          </Link>
          <Menu.Item key="2">Series</Menu.Item>
          <Menu.Item key="3">New Seasons</Menu.Item>
          <Menu.Item key="4"> New Episodes</Menu.Item>
        </Menu>
      </Header>
      <Content style={{ padding: "0 50px" }}>
       
          <Breadcrumb style={{ margin: "16px 0" }}>
            <Breadcrumb.Item>Home</Breadcrumb.Item>
            <Breadcrumb.Item>List</Breadcrumb.Item>
            <Breadcrumb.Item>App</Breadcrumb.Item>
          </Breadcrumb>
          
       

        <main className="site-layout-content">{props.children}</main>
      </Content>
      <Footer style={{ textAlign: "center" }}>
        ©2021 Created by Florentina Matei
      </Footer>
    </Layout>
  );
}

export default LayoutSite;
