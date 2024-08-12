import { CorderBase} from '@baseapp/corder/corder/corder.base.model';

export class CorderApiConstants {
    public static readonly autoSuggestService: any = {
        url: '/rest/corders/autosuggest',
        method: 'GET',
        showloading: true
    };
    public static readonly create: any = {
        url: '/rest/corders/',
        method: 'POST',
        showloading: true
    };
    public static readonly getDatatableData: any = {
        url: '/rest/corders/datatable',
        method: 'POST',
        showloading: true
    };
    public static readonly getById: any = {
        url: '/rest/corders/{sid}',
        method: 'GET',
        showloading: true
    };
    public static readonly delete: any = {
        url: '/rest/corders/{ids}',
        method: 'DELETE',
        showloading: true
    };
    public static readonly update: any = {
        url: '/rest/corders/',
        method: 'PUT',
        showloading: true
    };
    public static readonly getBypk_ordernoIndex: any = {
        url: '/rest/corders/getbypk_orderno/{order no}',
        method: 'GET',
        showloading: true
    };
}