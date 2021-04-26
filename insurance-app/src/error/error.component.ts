import { Component } from "@angular/core";

@Component({
    template: `<h5 class="errorMessage">Error:404</h5>`,
    styles: [`
        .errorMessage{
            margin-top:150px;
            font-size:150px;
            text-align:center;
        }
    `]
})
export class Error404Component {
    constructor() {

    }
}