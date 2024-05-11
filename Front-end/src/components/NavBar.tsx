import { Link } from "react-router-dom";

export const NavBar = () => {
	return (
		<nav>
			<ul>
				<li>
					<Link to="/home">Home</Link>
				</li>
				<li>
					<Link to="/record">IP Record</Link>
				</li>
			</ul>
		</nav>
	);
};

export default NavBar;
