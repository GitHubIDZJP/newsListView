package com.android.newslistview.vo.response.news;

import java.util.List;

public class ListNewsVO {

    /**
     * reason : 成功的返回
     * result :
     * error_code : 0
     */

    private String reason;
    private ResultEntity result;
    private int error_code;

    public void setReason(String reason) {
        this.reason = reason;
    }

    public void setResult(ResultEntity result) {
        this.result = result;
    }

    public void setError_code(int error_code) {
        this.error_code = error_code;
    }

    public String getReason() {
        return reason;
    }

    public ResultEntity getResult() {
        return result;
    }

    public int getError_code() {
        return error_code;
    }

    public static class ResultEntity {
        /**
         * stat : 1
         * data : [{...}]
         */
        private String stat;
        private List<DataEntity> data;

        public void setStat(String stat) {
            this.stat = stat;
        }

        public void setData(List<DataEntity> data) {
            this.data = data;
        }

        public String getStat() {
            return stat;
        }

        public List<DataEntity> getData() {
            return data;
        }

        public static class DataEntity {
            /**
             * uniquekey : 5f85f80847fc4709cee1ad9390b9ed9d
             * title : 高虎城全面阐释中国成就 南开学子交流新时代新内涵
             * date : 2017-11-20 21:47
             * category : 头条
             * author_name : 中国新闻网
             * url : http://mini.eastday.com/mobile/171120214733416.html
             * thumbnail_pic_s : http://07.imgmini.eastday.com/mobile/20171120/20171120214733_cc7ebdd495a11d003fd481317e23c036_3_mwpm_03200403.jpg
             * thumbnail_pic_s02 : http://07.imgmini.eastday.com/mobile/20171120/20171120214733_cc7ebdd495a11d003fd481317e23c036_1_mwpm_03200403.jpg
             * thumbnail_pic_s03 : http://07.imgmini.eastday.com/mobile/20171120/20171120214733_cc7ebdd495a11d003fd481317e23c036_2_mwpm_03200403.jpg
             */

            private String uniquekey;
            private String title;
            private String date;
            private String category;
            private String author_name;
            private String url;
            private String thumbnail_pic_s;
            private String thumbnail_pic_s02;
            private String thumbnail_pic_s03;

            public void setUniquekey(String uniquekey) {
                this.uniquekey = uniquekey;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public void setDate(String date) {
                this.date = date;
            }

            public void setCategory(String category) {
                this.category = category;
            }

            public void setAuthor_name(String author_name) {
                this.author_name = author_name;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            public void setThumbnail_pic_s(String thumbnail_pic_s) {
                this.thumbnail_pic_s = thumbnail_pic_s;
            }

            public void setThumbnail_pic_s02(String thumbnail_pic_s02) {
                this.thumbnail_pic_s02 = thumbnail_pic_s02;
            }

            public void setThumbnail_pic_s03(String thumbnail_pic_s03) {
                this.thumbnail_pic_s03 = thumbnail_pic_s03;
            }

            public String getUniquekey() {
                return uniquekey;
            }

            public String getTitle() {
                return title;
            }

            public String getDate() {
                return date;
            }

            public String getCategory() {
                return category;
            }

            public String getAuthor_name() {
                return author_name;
            }

            public String getUrl() {
                return url;
            }

            public String getThumbnail_pic_s() {
                return thumbnail_pic_s;
            }

            public String getThumbnail_pic_s02() {
                return thumbnail_pic_s02;
            }

            public String getThumbnail_pic_s03() {
                return thumbnail_pic_s03;
            }
        }
    }
}

