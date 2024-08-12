import { Injectable,inject } from '@angular/core';
import { Observable, of } from 'rxjs';
import { BaseService } from '@baseapp/base.service';
import { CopviewBase} from './copview.base.model';
import { CopviewApiConstants } from './copview.api-constants';


@Injectable({
  providedIn: 'root'
})
export class CopviewService {

public baseService = inject(BaseService);

  
	  getProtoTypingData(): Observable<any> {
	      const subject:Observable<CopviewBase> = new Observable(observer => {
	        const data =  require('base/assets/sample-data/copview.json');
	        observer.next(data as CopviewBase);
	      });
	      return subject;
	  }
	 
		getProtoTypingDataById(...args: any): Observable<any> {
	    const params = args[0];
	    const key = Object.keys(params);
	    let foundData: boolean = false;
	    let data: any = {};
	    const subject: Observable<CopviewBase> = new Observable(observer => {
	      const response = require('base/assets/sample-data/copview.json');
	      response.map((o: any) => {
	        foundData = key.every((d: string) => {
	          return o[d] == params[d];
	        })
	        if (foundData) {
	          data = o;
	        }
	      })
	      observer.next(data as CopviewBase);
	    });
	    return subject;
	  }


	  getProtoTypingDataByParams(...args: any): Observable<any> {
	    const params = args[0];
	    const key = Object.keys(params);
	    let foundData: boolean = false;
	    let data: any = {};
	    const subject: Observable<CopviewBase> = new Observable(observer => {
	      const response = require('base/assets/sample-data/copview.json');
	      response.map((o: any) => {
	        foundData = key.every((d: string) => {
	          return o[d] == params[d];
	        })
	        if (foundData) {
	          data = o;
	        }
	      })
	      observer.next(data as CopviewBase);
	    });
	    return subject;
	  }
	  
	deletewithBodyParams(...args: any):Observable<any>{
      const serviceOpts = CopviewApiConstants.delete;
      const params= args[0];
      
      const subject = new Observable(observer => {
        this.baseService.deletewithBodyParams(serviceOpts,params).subscribe((response: any) => {
          observer.next(response);
        },
        (err:any) => {
          observer.error(err);
        });
      });
  
      return subject;
  }
    update(...args: any):Observable<any>{
        const serviceOpts = CopviewApiConstants.update;
        const params= args[0];
        
        const subject = new Observable(observer => {
          this.baseService.put(serviceOpts,params).subscribe((response: any) => {
            observer.next(response);
          },
          (err:any) => {
            observer.error(err);
          });
        });
    
        return subject;
    }
    create(...args: any):Observable<any>{
        const serviceOpts = CopviewApiConstants.create;
        const params= args[0];
        
        const subject = new Observable(observer => {
          this.baseService.post(serviceOpts,params).subscribe((response: any) => {
            observer.next(response);
          },
          (err:any) => {
            observer.error(err);
          });
        });
    
        return subject;
    }
    getResults(...args: any):Observable<any>{
        const serviceOpts = CopviewApiConstants.getResults;
        const params= args[0];
        
        const subject = new Observable(observer => {
          this.baseService.post(serviceOpts,params).subscribe((response: any) => {
            observer.next(response);
          },
          (err:any) => {
            observer.error(err);
          });
        });
    
        return subject;
    }
    delete(...args: any):Observable<any>{
        const serviceOpts = CopviewApiConstants.delete;
        const params= args[0];
        
        const subject = new Observable(observer => {
          this.baseService.delete(serviceOpts,params).subscribe((response: any) => {
            observer.next(response);
          },
          (err:any) => {
            observer.error(err);
          });
        });
    
        return subject;
    }
}
