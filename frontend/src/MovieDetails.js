import React from 'react'
import { Card, Divider, Row, Col } from "antd";
import { Link } from "react-router-dom";

function MovieDetails(props) {
   
    let movie = props.location.state.movie
     console.log(movie.seasons);
    return (
      <div>
        <Card
          key={movie.id}
          cover={<img alt={movie.title} src={movie.pictureLink} />}
        >
          <h3>{movie.title}</h3>
          <hr />
          <p>Rating: {movie.rating}</p>
          <p>
            Runtime: {movie.runtime} <small>min</small>
          </p>
          <p>Status: {movie.status}</p>
          <p>{movie.overview}</p>
          <Divider orientation="left">Seasons</Divider>
          <div className="site-card-wrapper featureBlock block">
            <div className="container-fluid">
              <Row gutter={[16, 16]}>
                {movie.seasons.map((season) => {
                  return (
                    <Col
                      className="gutter-row"
                      xs={{ span: 24 }}
                      sm={{ span: 24 }}
                      md={{ span: 24 }}
                      lg={{ span: 12 }}
                      xl={{ span: 8 }}
                      key={season.id}
                    >
                      <Link
                        to={{
                          pathname: `/season/${season.title}`,
                          state: { season: season },
                        }}
                      >
                        <Card
                          key={season.id}
                          hoverable
                          
                          cover={
                            <img
                              alt={season.title}
                              src="https://upload.wikimedia.org/wikipedia/en/thumb/e/e0/Game_of_Thrones_Season_8.png/220px-Game_of_Thrones_Season_8.png"
                              style={{ height: 300 }}
                            />
                          }
                        >
                          <h3>{season.title}</h3>
                          <hr />
                          <p>Number of episodes: {season.episodes.length}</p>
                        </Card>
                      </Link>
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

export default MovieDetails
