import { Component, OnInit } from '@angular/core';
import { AuthenticationService } from "./security/authentication.service";
import { Router } from "@angular/router";
import { TranslateService } from '@ngx-translate/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})

export class AppComponent implements OnInit{
  title = 'Hardware App';
  currentLanguage = 'hr';
  constructor(
    public authenticationService: AuthenticationService,
    private router: Router,
    public translate: TranslateService
  ) {
    translate.setDefaultLang('hr');
    translate.use('hr');
  }

  logout() {
    this.authenticationService.logout();
    this.router.navigate(['/login']).then();
  }

  onLanguageChange(_name: string) {
    this.translate.use(_name);
    this.currentLanguage = _name;
  }

  ngOnInit(): void {
  }

}
