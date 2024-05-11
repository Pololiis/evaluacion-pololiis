import RecordList from "../components/RecordList";

export const Record = () => {
	return (
		<>
			<RecordList url="http://localhost:8080/record">
			<h2 style={{fontSize:'3rem', margin:'10px'}}>Lista de IPs:</h2>
			</RecordList>
		</>
	);
};
