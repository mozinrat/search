package com.erecyclingcorps.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class DiscoverMetaDTO extends BaseDTO{

    /**
     * 
     */
    private static final long serialVersionUID = 800376627301189856L;
    private String header;
    private List<Widget> meta;
    private String buttonLabel;
    private String resultTitle;


    public String getHeader() {
        return header;
    }
    public void setHeader(String header) {
        this.header = header;
    }
    public String getButtonLabel() {
        return buttonLabel;
    }
    public void setButtonLabel(String buttonLabel) {
        this.buttonLabel = buttonLabel;
    }
    public String getResultTitle() {
        return resultTitle;
    }
    public void setResultTitle(String resultTitle) {
        this.resultTitle = resultTitle;
    }
    public List<Widget> getMeta() {
        return meta;
    }
    public void setMeta(List<ModelAttributeDTO> meta) {
        List<Widget> temp = new ArrayList<Widget>(meta.size());
        for(ModelAttributeDTO dto:meta){
            temp.add(new Widget(dto.getCode(), dto.getLabel(), new Tooltip(dto.getTigger(), dto.getHelptext())));
        }
        this.meta = temp;
    }



    class Widget implements Serializable {
        /**
         * 
         */
        private static final long serialVersionUID = 796362139471972003L;
        private String code;
        private String title;
        private Tooltip tooltip;

        public Widget(String code,String title,Tooltip tooltip){
            this.code=code;
            this.title=title;
            this.tooltip=tooltip;
        }

        public String getCode() {
            return code;
        }
        public void setCode(String code) {
            this.code = code;
        }
        public String getTitle() {
            return title;
        }
        public void setTitle(String title) {
            this.title = title;
        }
        public Tooltip getTooltip() {
            return tooltip;
        }
        public void setTooltip(Tooltip tooltip) {
            this.tooltip = tooltip;
        }
    }

    class Tooltip implements Serializable {

        /**
         * 
         */
        private static final long serialVersionUID = 6384095630848146372L;
        private String trigger;
        private String text;

        public Tooltip(String trigger,String text){
            this.trigger=trigger;
            this.text=text;
        }
        public String getTrigger() {
            return trigger;
        }
        public void setTrigger(String trigger) {
            this.trigger = trigger;
        }
        public String getText() {
            return text;
        }
        public void setText(String text) {
            this.text = text;
        }
    }

}