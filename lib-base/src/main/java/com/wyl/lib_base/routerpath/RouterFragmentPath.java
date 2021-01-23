package com.wyl.lib_base.routerpath;

/**
 * @create : wyl
 * @date : 2021/1/7
 * @备注：
 */
public class RouterFragmentPath {

    /**
     * 首页组件
     */
    public static class Home {
        private static final String HOME = "/module_home";

        /**
         * 首页
         */
        public static final String PAGER_HOME = HOME + "/Home";

    }

    /**
     * 项目 组件
     */
    public static class Work {
        private static final String WORK = "/module_work";

        /**
         * 项目 页面
         */
        public static final String PAGER_WROK = WORK + "/Work";
    }

    /**
     * 我的 组件
     */
    public static class Mine {
        private static final String MINE = "/module_mine";

        /**
         * 我的 页面
         */
        public static final String PAGER_MINE = MINE + "/Mine";
    }

}
