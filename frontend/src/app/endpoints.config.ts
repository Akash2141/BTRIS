import { environment } from 'src/environments/environment';

export const Endpoints={
    customer:{
        login:environment.api+'/auth/customer/login',
        register:environment.api+'/auth/customer/register'
    },
    seller:{
        login:environment.api+'/auth/seller/login',
        register:environment.api+'/auth/seller/register'
    }
}