
;; -- Namespace ---------------------------------------------------------------
;; ----------------------------------------------------------------------------

(ns time.current)



;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn get-year
  ; @return (integer)
  []
  (.getFullYear (js/Date.)))

(defn get-month
  ; @return (integer)
  [])
  ; TODO

(defn get-day
  ; @return (integer)
  [])
  ; TODO

(defn get-date
  ; @return (string)
  [])
  ; TODO

(defn get-hours
  ; @return (integer)
  [])
  ; TODO

(defn get-hours-left-from-this-day
  ; @return (integer)
  []
  (let [hours (get-hours)]
       (- 24 hours)))

(defn get-minutes
  ; @return (integer)
  [])
  ; TODO

(defn get-minutes-left-from-this-hour
  ; @return (integer)
  []
  (let [minutes (get-minutes)]
       (- 60 minutes)))

(defn get-seconds
  ; @return (integer)
  [])
  ; TODO

(defn get-seconds-left-from-this-minute
  ; @return (integer)
  []
  (let [seconds (get-seconds)]
       (- 60 seconds)))

(defn get-milliseconds
  ; @return (integer)
  [])
  ; TODO

(defn get-milliseconds-left-from-this-second
  ; @return (integer)
  [])
  ; TODO

(defn get-milliseconds-left-from-this-minute
  ; @return (integer)
  []
  (let [seconds-left (get-seconds-left-from-this-minute)]
       (* 1000 seconds-left)))
