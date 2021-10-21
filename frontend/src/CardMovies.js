import React, { useState, useEffect } from "react";
import { Card, Col, Row } from "antd";
import { ArrowRightOutlined } from "@ant-design/icons";
import { Link } from "react-router-dom";

function CardMovies(props) {
  let [recentMovies, setRecentMovies] = useState([]);
  const [isLoading, setIsLoading] = useState(true);

  useEffect(() => {
    setIsLoading(true);
    fetch("http://localhost:8080/api/series")
      .then((resp) => resp.json())
      .then((data) => {
        console.log(data);
        setRecentMovies(data);
        setIsLoading(false);
      });
  }, []);

  if (isLoading) {
    return <p>Is Loading...</p>;
  }

  return (
    <div id="feature" className="block featureBlock site-card-wrapper">
      <div className="container-fluid">
        <Row gutter={[8, 8]}>
          {recentMovies.map((movie) => {
            return (
              <Col
                style={{ marginBottom: 10 }}
                className="gutter-row"
                xs={{ span: 24 }}
                sm={{ span: 24 }}
                md={{ span: 24 }}
                lg={{ span: 12 }}
                key={movie.id}
              >
                <Card
                  key={movie.id}
                  cover={
                    <img
                      alt={movie.title}
                      src={movie.pictureLink}
                      style={{ height: 450 }}
                    />
                  }
                >
                  <Link
                    to={{
                      pathname: `/movie/${movie.title}`,
                      state: { movie: movie },
                    }}
                    key={movie.id}
                  >
                    <h3>{movie.title}</h3>
                    <span>
                      <ArrowRightOutlined />
                    </span>
                  </Link>
                  <hr />

                  <p>Rating: {movie.rating}</p>
                  <p>
                    Runtime: {movie.runtime} <small>min</small>
                  </p>
                  <p>Status: {movie.status}</p>
                </Card>
              </Col>
            );
          })}
        </Row>
      </div>
    </div>
  );
}

export default CardMovies;
