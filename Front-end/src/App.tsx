import { useEffect, useState } from "react";
import { getVisitor, postVisitor } from "./services/index";
import { Visitor } from "./interfaces/visitor.interface";
import { Route, Routes } from "react-router-dom";
import Home from "./pages/Home";
import Record from "./pages/Record";
import NavBar from "./components/NavBar";
import Category from "./pages/Category";

function App() {
	const [visitor, setVisitor] = useState<Visitor>({
		ip: "",
		date: "",
		hour: "",
	});

	useEffect(() => {
		(async () => {
			const newVisitor: Visitor = await getVisitor();
			setVisitor(newVisitor);
		})();
	}, []);

	useEffect(() => {
		postVisitor(visitor);
	}, [visitor]);
	return (
		<>
			<NavBar />
			<Routes>
				<Route path="/home" element={<Home />} />
				<Route path="/record" element={<Record />} />
				<Route path="/category" element={<Category />} />
			</Routes>
		</>
	);
}

export default App;
