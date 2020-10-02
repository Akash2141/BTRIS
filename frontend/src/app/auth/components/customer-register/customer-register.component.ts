import { ChangeDetectionStrategy, Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Subject } from 'rxjs';
import { takeUntil } from 'rxjs/operators';
import { AuthService } from '../../services/auth.service';

@Component({
  selector: 'app-customer-register',
  templateUrl: './customer-register.component.html',
  styleUrls: ['./customer-register.component.scss'],
  changeDetection: ChangeDetectionStrategy.OnPush
})
export class CustomerRegisterComponent implements OnInit {

  customerRegisterForm: FormGroup;
  private _unSubscribe = new Subject<any>();

  constructor(
    private _fb: FormBuilder,
    private _authService: AuthService
  ) { }

  ngOnInit() {
    this.createForm();
  }

  createForm() {
    this.customerRegisterForm = this._fb.group({
      email: ["", Validators.required],
      password: ["", Validators.required],
      confirmPassword: ["", Validators.required],
    })
  }

  onSubmit(event) {
    let customer = this.customerRegisterForm.getRawValue();
    this._authService.customerRegister(customer).pipe(takeUntil(this._unSubscribe)).subscribe(data => {
      console.log('user registered successfully')
    })
  }

  ngOnDestroy() {
    this._unSubscribe.next();
    this._unSubscribe.complete();
  }
}
