import { CustomerBase} from '@baseapp/customer/customer/customer.base.model';

export class CustomerApiConstants {
    public static readonly autoSuggestService: any = {
        url: '/rest/customers/autosuggest',
        method: 'GET',
        showloading: true
    };
    public static readonly delete: any = {
        url: '/rest/customers/{ids}',
        method: 'DELETE',
        showloading: true
    };
    public static readonly getBypk_customerIndex: any = {
        url: '/rest/customers/getbypk_customer/{customer no}',
        method: 'GET',
        showloading: true
    };
    public static readonly getDatatableData: any = {
        url: '/rest/customers/datatable',
        method: 'POST',
        showloading: true
    };
    public static readonly create: any = {
        url: '/rest/customers/',
        method: 'POST',
        showloading: true
    };
    public static readonly lookupCustomerLookup1: any = {
        url: '/rest/customers/lookup/customerlookup1',
        method: 'GET',
        showloading: false
    };
    public static readonly update: any = {
        url: '/rest/customers/',
        method: 'PUT',
        showloading: true
    };
    public static readonly getById: any = {
        url: '/rest/customers/{sid}',
        method: 'GET',
        showloading: true
    };
}