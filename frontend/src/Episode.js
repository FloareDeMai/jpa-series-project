import React from 'react'
import {  Divider } from "antd";

function Episode(props) {
    let episode = props.location.state.episode
    return (
      <div>
        <Divider orientation="left">{episode.title}</Divider>
        <p>{episode.overview}</p>
      </div>
    );
}

export default Episode
