
(ns time.now)

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn elapsed
  ; @description
  ; Returns a high resolution timestamp in milliseconds that represents the time elapsed since
  ; the time when navigation has started in window contexts, or the time when the worker is run
  ; in Worker and ServiceWorker contexts.
  ;
  ; @usage
  ; (elapsed)
  ;
  ; @return (ms)
  []
  #?(:cljs (.now js/performance)))
