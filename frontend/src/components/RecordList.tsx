import { useEffect, useState, ReactNode } from "react";
import { getVisitors } from "../services/get-visitors.service";
import styles from "./styles/RecordList.module.css";
import { Record } from "../interfaces/record.interface";
import { getCategories } from "../services/get-categories.service";

const RecordList = ({
	children,
	url,
}: {
	children: ReactNode;
	url: string;
}) => {
	const [data, setData] = useState<Record[]>([]);
	const [categories, setCategories] = useState<string[]>([]);
	const [comment, setComment] = useState("");

	useEffect(() => {
		fetchVisitorsData();
		fetchCategories();
	}, []);

	const fetchVisitorsData = async () => {
		const visitors: Record[] = await getVisitors(url);
		setData(visitors);
	};

	const fetchCategories = async () => {
		const categories: string[] = await getCategories();
		setCategories(categories);
	};

	return (
		<div className={styles.container}>
			{children}
			<table>
				<tr>
					<th>IP</th>
					<th>Visits</th>
					<th>Bloqued</th>
					<th>Category</th>
					<th>Comment</th>
				</tr>
				{data.map((visitor) => (
					<tr key={visitor.id}>
						<td>{visitor.ip}</td>
						<td>{visitor.totalVisits}</td>
						<td>{visitor.isBlocked ? "Yes" : "No"}</td>
						<td>
							{
								<select name="category">
									<option value="undefined">Select Category</option>
									{categories.map((category) => (
										<option key={category} value={category}>
											{category}
										</option>
									))}
								</select>
							}
						</td>
						<td>{<textarea />}</td>
					</tr>
				))}
			</table>
		</div>
	);
};

export default RecordList;
