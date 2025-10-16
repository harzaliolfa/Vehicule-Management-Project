export class Vehicule{
    constructor(
         // When you create a new vehicle, it doesn’t have an id yet (the database will assign it automatically).
        public id: number | null,
        public brand: string,
        public model : string,
        public color : string,
        public year : number
    ){

    }
}