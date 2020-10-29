package leetCodeProj.dto;

import java.math.BigDecimal;

public class PtlPositionAnalysis001Dto extends AssetTargetDb {

    /**
     * <意义，目的和功能，以及可能被用到的地方>
     */
    @SuppressWarnings("unused")
    private static final long serialVersionUID = 8496377411327582052L;

    /**
     * 修正久期扩展
     */
    private  BigDecimal mdurationAmend;

    public BigDecimal getMdurationAmend() {
        return mdurationAmend;
    }

    public void setMdurationAmend(BigDecimal mdurationAmend) {
        this.mdurationAmend = mdurationAmend;
    }

    /**
     * 分类名称
     */
    private  String typeName;


    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }


    /**
     * 父节点
     */
    private String parentInfo;

    /**
     * 子节点
     */
    private String childInfo;

    /**
     * 是否有子节点
     */
    private String hasChildren;

    public String getParentInfo() {
        return parentInfo;
    }

    public void setParentInfo(String parentInfo) {
        this.parentInfo = parentInfo;
    }

    public String getChildInfo() {
        return childInfo;
    }

    public void setChildInfo(String childInfo) {
        this.childInfo = childInfo;
    }

    public String getHasChildren() {
        return hasChildren;
    }

    public void setHasChildren(String hasChildren) {
        this.hasChildren = hasChildren;
    }


}
