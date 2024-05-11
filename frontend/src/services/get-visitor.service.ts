import axios from "axios";
import { Visitor } from "../interfaces/visitor.interface";

export const getVisitor = async (): Promise<Visitor> => {
		const response = await axios.get("https://geolocation-db.com/json/");
		const { IPv4 } = response.data;

		const newVisitor: Visitor = {
			ip: IPv4,
			date: new Date().toLocaleDateString(),
			hour: new Date().toLocaleTimeString(),
		};

		return newVisitor;
};