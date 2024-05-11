import axios from "axios";
import { Visitor } from "../interfaces/visitor.interface";
import { Record } from "../interfaces/record.interface";

export const getVisitors = async (url: string): Promise<Visitor[]|Record[]> => {
    const response = await axios.get(url);
    return response.data;
};