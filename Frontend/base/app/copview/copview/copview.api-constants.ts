import { CopviewBase} from '@baseapp/copview/copview/copview.base.model';

export class CopviewApiConstants {
    public static readonly update: any = {
        url: '/rest/copviews/',
        method: 'PUT',
        showloading: true
    };
    public static readonly create: any = {
        url: '/rest/copviews/',
        method: 'POST',
        showloading: true
    };
    public static readonly getResults: any = {
        url: '/rest/copviews/getresults',
        method: 'POST',
        showloading: true
    };
    public static readonly delete: any = {
        url: '/rest/copviews/',
        method: 'DELETE',
        showloading: true
    };
}