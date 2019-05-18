package javaBean;

import java.util.List;
public class Page<T> {
    // 包含5个属性
    // 当前页
    private int pageCode;
    // 总页数 = 总记录数/每页显示的记录条数
    // private int totalPage;
    // 总记录数
    private int totalCount;
    // 每页显示的记录条数
    private int pageSize;
    // 每页显示的数据
    private List<T> GoodsBeanList;
    private List<T> GoodsOrderBeanList;
    private List<T> SignHouseBeanList;

    private List<House> HouseBeanList;
    public int getPageCode() {
        return pageCode;
    }
    public void setPageCode(int pageCode) {
        this.pageCode = pageCode;
    }

    // totalPage 也是PageBean的一个属性
    // 通过计算，获取总页面
    public int getTotalPage() {
        // 获取总页数，如果100条，一页显示10条，页数10，如果109条，是11页
        int totalPage = totalCount / pageSize;
        if(totalCount % pageSize == 0){
            return totalPage;
        }else{
            return totalPage + 1;
        }
    }
	/*public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}*/
    public int getTotalCount() {
        return totalCount;
    }
    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }
    public int getPageSize() {
        return pageSize;
    }
    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public List<T> getGoodsBeanList() {
        return GoodsBeanList;
    }

    public void setGoodsBeanList(List<T> GoodsBeanList) {
        this.GoodsBeanList = GoodsBeanList;
    }

    public List<House> getHouseBeanList() {
        return HouseBeanList;
    }

    public void setHouseBeanList(List<House> houseBeanList) {
        HouseBeanList = houseBeanList;
    }

    public List<T> getGoodsOrderBeanList() {
        return GoodsOrderBeanList;
    }

    public void setGoodsOrderBeanList(List<T> goodsOrderBeanList) {
        GoodsOrderBeanList = goodsOrderBeanList;
    }

    public List<T> getSignHouseBeanList() {
        return SignHouseBeanList;
    }

    public void setSignHouseBeanList(List<T> signHouseBeanList) {
        SignHouseBeanList = signHouseBeanList;
    }
}
