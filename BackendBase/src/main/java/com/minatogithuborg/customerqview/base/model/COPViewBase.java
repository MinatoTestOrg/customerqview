package com.minatogithuborg.customerqview.base.model;

import com.vs.rappit.base.annotations.QueryView;
import com.vs.rappit.base.model.BaseJPAViewModel;
import jakarta.persistence.MappedSuperclass;


@QueryView(name = "query_for_queryviewtable_copview", keys = {  })
@MappedSuperclass
public class COPViewBase extends BaseJPAViewModel {
    


}