import { Component, OnInit,inject } from '@angular/core';
import { CorderDetailBaseComponent } from '@baseapp/corder/corder/corder-detail/corder-detail.base.component';
import { CorderService } from '@baseapp/corder/corder/corder.service';


@Component({
  selector: 'app-corder-detail',
  templateUrl: '../../../../../base/app/corder/corder/corder-detail/corder-detail.component.html',
  styleUrls: ['./corder-detail.scss']
})
export class CorderDetailComponent extends CorderDetailBaseComponent implements OnInit {
 
	
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