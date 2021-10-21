import './App.css';
import LayoutSite from './LayoutSite';
import { Route, Switch } from "react-router-dom";
import Home from './Home';
import MovieDetails from './MovieDetails';
import Season from './Season';
import Episode from './Episode';


function App() {
  return (
    <LayoutSite>
      <Switch>
        <Route exact path="/" component={Home}></Route>
        <Route exact path="/movie/:movieName" component={MovieDetails}></Route>
        <Route exact path="/season/:seasonName" component={Season}/>
        <Route exact path="/episode/:episodeName" component={Episode}/>
      </Switch>

    </LayoutSite>
  )
}

export default App;
