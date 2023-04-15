
(ns time.epoch
    (:require [time.converters :as converters]))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn epoch-ms
  ; @usage
  ; (epoch-ms)
  ;
  ; @return (ms)
  [])
  ; TODO

(defn epoch-s
  ; @usage
  ; (epoch-s)
  ;
  ; @return (s)
  [])
  ; TODO

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn epoch-ms->timestamp-string
  ; @param (ms) n
  ;
  ; @example
  ; (epoch-ms->timestamp-string 1640800860000)
  ; =>
  ; "2021-12-29T18:01:00.000Z"
  ;
  ; @return (string)
  [n])
  ; TODO

(defn epoch-s->timestamp-string
  ; @param (s) n
  ;
  ; @example
  ; (epoch-s->timestamp-string 1640800860)
  ; =>
  ; "2021-12-29T18:01:00.000Z"
  ;
  ; @return (string)
  [n])
  ; TODO

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn timestamp-string->epoch-ms
  ; @param (string) n
  ;
  ; @example
  ; (timestamp-string->epoch-ms "2021-12-29T18:01:00.000Z")
  ; =>
  ; 1640800860000
  ;
  ; @return (ms)
  [n])
  ; TODO

(defn timestamp-string->epoch-s
  ; @param (string) n
  ;
  ; @example
  ; (timestamp-string->epoch-s "2021-12-29T18:01:00.000Z")
  ; =>
  ; 1640800860
  ;
  ; @return (s)
  [n])
  ; TODO
