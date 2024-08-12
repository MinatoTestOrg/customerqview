import { Injectable, SecurityContext } from '@angular/core';

@Injectable({
  providedIn: 'root',
})


export class CopviewSharedBaseService{
    sharedData: any = {};

    setData(data: any) {
      this.sharedData = data;
    }
  
    getData() {
      return this.sharedData;
    }
}  