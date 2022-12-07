(ns rest-demo.lib.routes
  (:require
    [compojure.core :refer :all]
    [compojure.route :as route]
    [clojure.pprint :as pp]
    [clojure.string :as str]
    [clojure.data.json :as json]
    [rest-demo.lib.api :as api])
  (:gen-class))

(defn echo-route
  "Echo back the request"
  [req]
  {:status 200
   :headers {"Content-Type" "text/html"}
   :body (-> (str "GET '/' " req))})

(defn get-friends-route
  "Echo back a name"
  [req]
  {:status 200
   :headers {"Content-Type" "application/json"}
   :body (-> (api/get-friends))})

(defn add-friend-route
  "Endpoint for adding a friend"
  [req]
  {:status 200
   :headers {"Content-Type" "application/json"}
   :body (-> (api/add-friend (req :params)))})