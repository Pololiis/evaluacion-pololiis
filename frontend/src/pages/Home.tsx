import VisitorsList from "../components/VisitorsList";

export const Home = () => {
	return (
		<>
			<VisitorsList url="http://localhost:8080/home">
			<h2 style={{fontSize:'3rem', margin:'10px'}}>Lista de Visitantes:</h2>
			</VisitorsList>
		</>
	)
};
