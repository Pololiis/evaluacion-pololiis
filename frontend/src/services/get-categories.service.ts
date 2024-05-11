import axios from "axios";
import {Visitor} from '../interfaces/visitor.interface'  

interface Category {
	id: number,
	name: string;
	visitors: Visitor[]
}

export const getCategories = async (): Promise<Category[]> => {
	const response = await axios.get("http://localhost:8080/category");
	return response.data;
};
