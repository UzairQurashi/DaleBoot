//package app.dalboot.mobiavialdo.com.daleboot.viewholders;
//
//import android.databinding.ViewDataBinding;
//import android.support.v7.widget.RecyclerView;
//import android.view.View;
//
//import app.dalboot.mobiavialdo.com.daleboot.BR;
//
//
///**
// * Author: Uzair Qureshi
// * Date:  10/2/17.
// * Description:
// */
//
//public class BaseViewHolder extends RecyclerView.ViewHolder {
//    public ViewDataBinding dataBinding;
//
//    public BaseViewHolder(View itemView, ViewDataBinding dataBinding) {
//        super(itemView);
//        this.dataBinding = dataBinding;
//    }
//
//    public BaseViewHolder(View root) {
//        super(root);
//    }
//
//    /**
//     * binds the itemslayout data
//     * @param obj
//     */
//   public void bindData(Object obj){
//
//        dataBinding.setVariable(BR._all,obj);
//        dataBinding.executePendingBindings();
//
//    }
//}
