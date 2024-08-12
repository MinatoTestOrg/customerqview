import { Component, OnInit,inject } from '@angular/core';
import { CproductListBaseComponent } from '@baseapp/cproduct/cproduct/cproduct-list/cproduct-list.base.component';
import { CproductService } from '@baseapp/cproduct/cproduct/cproduct.service';


@Component({
  selector: 'app-cproduct-list',
  templateUrl: '../../../../../base/app/cproduct/cproduct/cproduct-list/cproduct-list.component.html',
  styleUrls: ['./cproduct-list.scss']
})
export class CproductListComponent extends CproductListBaseComponent implements OnInit {
 
	
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