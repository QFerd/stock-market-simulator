export class RegisterStudentTemplate
 { 
     
    username: string; 
    password: string;
    // userRole: string;

    constructor(username:string, password:string, userRole: string ){
        this.username=username;
        this.password = password;
    }
}