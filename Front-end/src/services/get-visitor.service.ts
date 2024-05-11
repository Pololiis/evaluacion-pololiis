import axios from "axios";
import { Visitor } from "../interfaces/visitor.interface";

export const getVisitor = async (): Promise<Visitor|undefined> => {
	try {
		const response = await axios.get("https://geolocation-db.com/json/");
		const { IPv4 } = response.data;

		const newVisitor: Visitor = {
			ip: IPv4,
			date: new Date().toLocaleDateString(),
			hour: new Date().toLocaleTimeString(),
		};

		return newVisitor;

	} catch (error) {
		console.error("Error al obtener la información de la IP:", error);
		return undefined;
	}
};