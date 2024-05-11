import axios from "axios";
import { Visitor } from "../interfaces/visitor.interface";

export const postVisitor = async (visitor: Visitor) => {
	try {
		const response = await axios.post(
			"http://localhost:8080/home",
			visitor
		);
		console.log(response.data);
	} catch (error) {
		console.error("Error creating post:", error);
	}
};
