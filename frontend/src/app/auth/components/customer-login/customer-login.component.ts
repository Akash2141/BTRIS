import { ChangeDetectionStrategy, Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Subject } from 'rxjs';
import { takeUntil } from 'rxjs/operators';
import { AppConfig } from 'src/app/config/app.config';
import { AuthService } from '../../services/auth.service';

@Component({
  selector: 'app-customer-login',
  templateUrl: './customer-login.component.html',
  styleUrls: ['./customer-login.component.scss'],
  changeDetection: ChangeDetectionStrategy.OnPush
})
export class CustomerLoginComponent implements OnInit {

  customerLoginForm: FormGroup;
  title: string;
  private _unSubscribe = new Subject<any>();

  constructor(
    private _fb: FormBuilder,
    private _authService: AuthService
  ) {
    this.title = AppConfig.title;
  }

  ngOnInit() {
    this.createForm();
  }

  createForm() {
    this.customerLoginForm = this._fb.group({
      email: ["", Validators.required],
      password: ["", Validators.required]
    })
  }

  onSubmit(event) {
    let { email, password } = this.customerLoginForm.getRawValue();
    this._authService.customerLogin(email, password).pipe(takeUntil(this._unSubscribe)).subscribe(data => {
      console.log('user has been logged in successfully');
    })
  }

}
