import { useEffect, useState, ReactNode } from "react";
import { Visitor } from "../interfaces/visitor.interface";
import { getVisitors } from "../services/get-visitors.service";
import styles from "./styles/VisitorList.module.css";

const VisitorsList = ({
	children,
	url,
}: {
	children: ReactNode;
	url: string;
}) => {
	const [data, setData] = useState<Visitor[]>([]);
	
	useEffect(() => {
		fetchVisitorsData();
	}, []);

	const fetchVisitorsData = async () => {
		const visitors: Visitor[] = await getVisitors(url);
		setData(visitors);
	};

	return (
		<div className={styles.container}>
			{children}
			<table className={styles.table}>
				<tr>
					<th>IP</th>
					<th>Date</th>
					<th>Hour</th>
				</tr>
				<tbody>
					{data.map((visitor) => (
						<tr>
							<td>{visitor.ip}</td>
							<td>{visitor.date}</td>
							<td>{visitor.hour}</td>
						</tr>
					))}
				</tbody>
			</table>
		</div>
	);
};

export default VisitorsList;
