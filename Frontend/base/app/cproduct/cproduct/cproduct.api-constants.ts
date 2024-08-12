import { CproductBase} from '@baseapp/cproduct/cproduct/cproduct.base.model';

export class CproductApiConstants {
    public static readonly delete: any = {
        url: '/rest/cproducts/{ids}',
        method: 'DELETE',
        showloading: true
    };
    public static readonly lookupCProductLookup1: any = {
        url: '/rest/cproducts/lookup/cproductlookup1',
        method: 'GET',
        showloading: false
    };
    public static readonly getById: any = {
        url: '/rest/cproducts/{sid}',
        method: 'GET',
        showloading: true
    };
    public static readonly getDatatableData: any = {
        url: '/rest/cproducts/datatable',
        method: 'POST',
        showloading: true
    };
    public static readonly update: any = {
        url: '/rest/cproducts/',
        method: 'PUT',
        showloading: true
    };
    public static readonly autoSuggestService: any = {
        url: '/rest/cproducts/autosuggest',
        method: 'GET',
        showloading: true
    };
    public static readonly getBypk_productidIndex: any = {
        url: '/rest/cproducts/getbypk_productid/{product id}',
        method: 'GET',
        showloading: true
    };
    public static readonly create: any = {
        url: '/rest/cproducts/',
        method: 'POST',
        showloading: true
    };
}