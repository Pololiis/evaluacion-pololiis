import { useEffect, useState } from "react";
import { getCategories } from "../services/get-categories.service";
import { Visitor } from "../interfaces/visitor.interface";
import styles from "./styles/Category.module.css";

interface Category {
	id: number;
	name: string;
	visitors: Visitor[];
}

export const Category = () => {
	const [categories, setCategories] = useState<Category[]>([]);

	useEffect(() => {
		fetchCategoriesData();
	}, []);

	const fetchCategoriesData = async () => {
		const categories: Category[] = await getCategories();
		setCategories(categories);
	};

	return (
		<div className={styles.container}>
			<table>
				<thead>
					<tr>
						<th>Category</th>
					</tr>
				</thead>
				<tbody>
					{categories.map((category) => (
						<tr key={category.id}>
							<td>{category.name}</td>
						</tr>
					))}
				</tbody>
			</table>
		</div>
	);
};
