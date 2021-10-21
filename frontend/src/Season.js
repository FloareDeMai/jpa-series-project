import React from 'react'
import { Card, Divider, Row, Col } from "antd";
import {
  AimOutlined
} from "@ant-design/icons";

import { Link } from "react-router-dom";


function Season(props) {
    let season = props.location.state.season
    console.log(season);
    return (
      <div>
        <Card
          key={season.id}
          cover={
            <img
              alt={season.title}
              src="https://upload.wikimedia.org/wikipedia/en/thumb/e/e0/Game_of_Thrones_Season_8.png/220px-Game_of_Thrones_Season_8.png"
            />
          }
        >
          <p>{season.overview}</p>
          <Divider orientation="left">Episodes</Divider>
          <div className="site-card-wrapper featureBlock block">
            <div className="container-fluid">
              <Row gutter={[16, 16]}>
                {season.episodes.map((episode) => {
                  return (
                    <Col
                      className="gutter-row"
                      xs={{ span: 24 }}
                      sm={{ span: 24 }}
                      md={{ span: 24 }}
                      lg={{ span: 12 }}
                      xl={{ span: 8 }}
                      xxl={{span:8}}
                      key={episode.id}
                    >
                      <Card
                        key={episode.id}
          
                        cover={
                          <img
                            alt={episode.title}
                            src="https://upload.wikimedia.org/wikipedia/en/thumb/e/e0/Game_of_Thrones_Season_8.png/220px-Game_of_Thrones_Season_8.png"
                            style={{ height: 300 }}
                          />
                        }
                      >
                        <h3>
                          <span>{episode.episode_number + " "}</span>
                          {episode.title}
                        </h3>
                        <hr />
                        <Link
                          to={{
                            pathname: `/episode/${episode.title}`,
                            state: { episode: episode },
                          }}
                        >
                          <div
                            style={{ textAlign: "center", marginTop: "10%" }}
                          >
                            <span>More details </span>
                            <AimOutlined theme="outlined" />
                          </div>
                        </Link>
                      </Card>
                    </Col>
                  );
                })}
              </Row>
            </div>
          </div>
        </Card>
      </div>
    );
}

export default Season
