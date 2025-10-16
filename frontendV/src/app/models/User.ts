export class User{
    constructor(
         // When you create a new vehicle, it doesn’t have an id yet (the database will assign it automatically).
        public id: number | null,
        public firstName: string,
        public lastName : string,
        public login : string,
        public password : string
    ){

    }
}