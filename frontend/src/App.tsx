import { useEffect, useState } from "react";
import { getVisitor, postVisitor } from "./services/index";
import { Visitor } from "./interfaces/visitor.interface";
import { Navigate, Route, Routes } from "react-router-dom";
import NavBar from "./components/NavBar";
import { Home, Record, Category } from "./pages/index"

function App() {
	const [visitor, setVisitor] = useState<Visitor>({
		id: 0,
		ip: "",
		date: "",
		hour: "",
	});

	useEffect(() => {
		fetchVisitorData();
	}, []);

	useEffect(() => {
		if (visitor.ip && visitor.date && visitor.hour) {
			postVisitor(visitor);
		}
	}, [visitor]);

	const fetchVisitorData = async () => {
		const newVisitor: Visitor = await getVisitor();
		setVisitor(newVisitor);
	};

	return (
		<>
			<NavBar />
			<Routes>
				<Route path="/" element={<Navigate replace to="/home" />} />
				<Route path="/home" element={<Home />} />
				<Route path="/record" element={<Record />} />
				<Route path="/category" element={<Category />} />
			</Routes>
		</>
	);
}

export default App;
