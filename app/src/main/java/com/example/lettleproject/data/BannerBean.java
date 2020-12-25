package com.example.lettleproject.data;

public class BannerBean {
    @Override
    public String toString() {
        return "BannerBean{" +
                "id=" + id +
                ", ad_position_id=" + ad_position_id +
                ", media_type=" + media_type +
                ", name='" + name + '\'' +
                ", link='" + link + '\'' +
                ", image_url='" + image_url + '\'' +
                ", content='" + content + '\'' +
                ", end_time=" + end_time +
                ", enabled=" + enabled +
                '}';
    }

    /**
         * id : 1
         * ad_position_id : 1
         * media_type : 1
         * name : 合作 谁是你的菜
         * link :
         * image_url : http://yanxuan.nosdn.127.net/65091eebc48899298171c2eb6696fe27.jpg
         * content : 合作 谁是你的菜
         * end_time : 0
         * enabled : 1
         */

        private int id;
        private int ad_position_id;
        private int media_type;
        private String name;
        private String link;
        private String image_url;
        private String content;
        private int end_time;
        private int enabled;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getAd_position_id() {
            return ad_position_id;
        }

        public void setAd_position_id(int ad_position_id) {
            this.ad_position_id = ad_position_id;
        }

        public int getMedia_type() {
            return media_type;
        }

        public void setMedia_type(int media_type) {
            this.media_type = media_type;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getLink() {
            return link;
        }

        public void setLink(String link) {
            this.link = link;
        }

        public String getImage_url() {
            return image_url;
        }

        public void setImage_url(String image_url) {
            this.image_url = image_url;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public int getEnd_time() {
            return end_time;
        }

        public void setEnd_time(int end_time) {
            this.end_time = end_time;
        }

        public int getEnabled() {
            return enabled;
        }

        public void setEnabled(int enabled) {
            this.enabled = enabled;
        }
}
