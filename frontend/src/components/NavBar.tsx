import { Link } from "react-router-dom";
import styles from "./styles/NavBar.module.css";

export const NavBar = () => {
	return (
		<nav className={styles.navigation}>
			<Link to="/home">Home</Link>
			<Link to="/record">IP Record</Link>
			<Link to="/category">Categories</Link>
		</nav>
	);
};

export default NavBar;
