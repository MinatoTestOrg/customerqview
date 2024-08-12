import { Component, OnInit,inject } from '@angular/core';
import { CproductDetailBaseComponent } from '@baseapp/cproduct/cproduct/cproduct-detail/cproduct-detail.base.component';
import { CproductService } from '@baseapp/cproduct/cproduct/cproduct.service';


@Component({
  selector: 'app-cproduct-detail',
  templateUrl: '../../../../../base/app/cproduct/cproduct/cproduct-detail/cproduct-detail.component.html',
  styleUrls: ['./cproduct-detail.scss']
})
export class CproductDetailComponent extends CproductDetailBaseComponent implements OnInit {
 
	
  ngAfterViewInit(): void {
    this.onAfterViewInit()
  }

  ngOnInit(): void {
    super.onInit();
  }

  ngOnChanges(changes:any){
    super.onChanges(changes);
  }
 
}