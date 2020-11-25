(ns stel-codes.views
  (:require [hiccup.page :as hp]
            [hiccup2.core :refer [html raw]]
            [hiccup.element :as he]
            [hiccup.form :as hf]))

(defn layout [title & content]
  (->
   (html {:lang "en"}
         [:head
          [:title title]
          [:meta {:charset "utf-8"}]
          [:meta {:http-equiv "X-UA-Compatible" :content "IE=edge"}]
          [:meta {:name "viewport" :content "width=device-width, initial-scale=1.0"}]
          (hp/include-css "/assets/reset.css")
          (hp/include-css "/assets/main.css")
          ; [:link {:rel "shortcut icon" :href "/assets/favicon.ico" :type "image/x-icon"}]
          ; (hp/include-css "/assets/minireset.css")
          ; (hp/include-css "/assets/main.css")
          ; (if (= (System/getenv "PROD") "true")
          ;   [:script
          ;    {:src "https://plausible.io/js/plausible.js",
          ;     :data-domain "cuter-news.herokuapp.com",
          ;     :defer "defer",
          ;     :async "async"}])
          ]
         [:body content])
   (str)))

(defn header []
  [:header
   [:nav
    (he/link-to {:id "logoLink"} "/" (raw (slurp "resources/svg/code.svg")))
    (he/link-to {:id "navName"} "/" "stel.codes")
    [:div#navBar.navBar-closed
     (he/unordered-list
      {:class "nav-ul-closed"}
      [(he/link-to "/portfolio" "Portfolio")
       (he/link-to "/resume" "Resume")
       (he/link-to "/tutoring" "Tutoring")
       (he/mail-to "stel@stel.codes" "E-Mail")])]]])

(defn home-page [context]
  (layout "stel.codes"
          (header)
          [:section.slideInUp
           [:p "programming tutor."]
           [:p "musician."]
           [:p "fullstack developer."]
           [:img.hero-selfie {:src "/assets/img/selfie.jpeg"}]]))
